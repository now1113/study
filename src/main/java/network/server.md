## vmware

### 설치하고 나서 network가 활성화 되어 있지 않다면.

ip link: 네트워크 인터페이스 확인

ip addr show ens33: 네트워크 확인

sudo ip link set ens33 up

sudo dhclient ens33

-> 수동으로 인터페이스 활성화

