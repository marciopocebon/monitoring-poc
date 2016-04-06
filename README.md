#### How to run
- Dowload and install VirtualBox @ [VirtualBox Downloads](https://www.virtualbox.org/wiki/Downloads)
- Download and install Vagrant @ [Vagrant Downloads](https://www.vagrantup.com/downloads.html)
- In the root directory of the project, run:
```bash
> vagrant up
```
- After Vagrant has downloaded and initialized the VM, the application can be run (in the same directory):
```bash
> ./activator run
```
(On Windows, please use `activator.bat run`)
- Navigate to `http://localhost:8080` to view the dashboard