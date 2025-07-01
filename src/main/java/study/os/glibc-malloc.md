# 1. malloc이란 

## 정의
`malloc`은 C 표준 라이브러리(`glibc`)에서 제공하는 **동적 메모리 할당 함수**로,  
프로그램 실행 중에 필요한 크기만큼의 메모리를 **힙 영역(Heap)** 에서 요청하여 할당받는다.

```c
void* malloc(size_t size);
```
- `size`: 바이트 단위의 요청 크기
- 반환값: 할당된 메모리 영역의 시작 주소 (실패 시 `NULL`)

> `malloc` = "memory allocate"의 줄임말  
> 기본적으로 **힙(Heap)** 공간에서 메모리를 할당함

## 관련 함수들

| 함수명         | 설명                  |
| ----------- | ------------------- |
| `malloc()`  | 메모리 할당              |
| `calloc()`  | 메모리 할당 + 0으로 초기화    |
| `realloc()` | 기존 메모리를 주어진 크기로 재조정 |
| `free()`    | 사용이 끝난 메모리를 반환      |


## 동작 개요
1. **메모리 요청**: 사용자로부터 size를 입력 받음
2. **적절한 블록 탐색**: glibc 내부에서 해당 크기를 처리할 수 있는 블록을 탐색
3. **할당 또는 새로 요청**: 내부 bin에서 꺼내거나 없으면 힙 확장 (brk/mmap)
4. **포인터 반환**: 메모리 주소 반환 (사용자는 이 주소로 데이터 사용 가능)

## 할당 대상 영역

### 1. Heap 영역
- 일반적인 크기의 할당은 `brk()`/`sbrk()`를 통해 힙을 확장해서 처리함
- 힙은 프로그램 데이터 영역 바로 위에 위치함

### 2. mmap 영역
- 일정 크기 이상(`mmap_threshold`)의 요청은 `mmap()` 시스템 콜을 통해 **페이지 단위**로 직접 할당
- 이 경우 **힙과 무관한 고유 주소 공간**에 할당됨

> 힙(`brk`)은 연속적 확장/축소가 필요 -> 단편화 영향 큼  
> 반면 `mmap`은 메모리를 따로 잡으므로 관리하기 쉬우나 오버헤드 존재


## 예시 코드

```c
#include <stdlib.h>
#include <stdio.h>

int main() {
    int* arr = malloc(10 * sizeof(int)); // int 10개 할당
    if (arr == NULL) {
        perror("malloc failed");
        return 1;
    }

    for (int i = 0; i < 10; i++) arr[i] = i;
    for (int i = 0; i < 10; i++) printf("%d ", arr[i]);

    free(arr); // 메모리 해제
    return 0;
}
```

## 실제 할당 흐름 (glibc 기준)

```text
malloc(size)
 └──> __libc_malloc
       └──> _int_malloc (glibc 내부 구현)
              ├──> fast bin / small bin / tcache 확인
              └──> 없으면 brk/mmap 통해 시스템 메모리 요청
```
> glibc 버전에 따라 `tcache`가 중간에 개입될 수 있음 (glibc 2.26+)


## 메모리 구조 예시 (32비트 환경)

```text
프로세스 메모리 구조 (낮은 주소 → 높은 주소)

+----------------------+ ← Text segment (코드)
|      .text           |
+----------------------+ ← Data segment (.data, .bss)
|      .data           |
|      .bss            |
+----------------------+ ← Heap (malloc, free)
|      Heap ↑ grows    |
+----------------------+
|      mmap 영역       |
+----------------------+
|      Stack ↓ shrinks |
+----------------------+
```

## 정리
- `malloc`은 **힙 기반의 동적 메모리 할당**을 제공하는 C 함수
- glibc는 내부적으로 다양한 최적화 구조 (bin, chunk, tcache 등)를 이용해 성능과 단편화를 조절
- 할당/해제 동작을 정확히 이해해야 메모리 누수나 단편화 이슈를 잡을 수 있음


# 2. JVM과 glibc malloc의 관계

## JVM도 malloc을 사용한다
- OpenJDK 기반의 JVM은 **기본적으로 C로 구현**되어 있으며, 네이티브 메모리 영역을 사용할 때  
  OS의 **glibc malloc/free 등 표준 C 할당 함수**를 직접 호출한다.
- 예를 들어 다음과 같은 경우 JVM 내부에서 `malloc()` 호출이 발생함.

