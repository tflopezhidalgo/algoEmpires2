Ejemplo
## Definición de pruebas
### Nombrar correctamente los archivos de pruebas

Al momento de definir un nuevo archivo que contendrá pruebas, ya sean unitarias o de integración, el patrón del nuevo archivo **deberá** ser `*Test.java`; además de ubicarse en `<directorio del proyecto>/test/`. A modo de ejemplo: `<mi proyecto>/test/<paquete>/MiNuevoArchivoTest.java`.

# algo3
algoempires


Trabajo practico 2 de la materia algoritmos y programacion 3 FIUBA


### No se usar git auxilio

te paras en el directorio donde queres que este la carpeta del tp

sos un tipo feliz y tiras

`git clone https://github.com/tomasLopezHidalgo/algoEmpires2.git`

aca se te bajo el repositorio entero


### Para desarrollar mi feature

Quiero hacer algo pero no romper todo el tp, como hago ?

`git branch -vv`

Te fijas que estes en el branch `master`

Parado en master, creas un branch con tu feature

`git checkout -b myFeature`

Automaticamente se te crea una branch QUE SALE DE MASTER.

Ojo con hacer branches de otros features si no queres enroscarte.

Laburas todo tu feature hasta que te sangran los dedos, una vez que estas seguro que todo te funciona, y estas listo para meter los cambios

Te fijas que refleje todos los cambios que necesitas

`git status`

Listo para agregar mis cambios!

a una rama nueva:

`git push origin myFeature`

a la rama donde estoy laburando

`git push origin myFeature:myFeature`

Con este comando pusheaste todos tus cambios a tu rama en el repositorio.

Trata de siempre pushear algo que *funcione* y con *tests*.

Una vez que pusheaste algo automaticamente se va a correr Travis y te va a notificar con un mail si la build se corre o no.


### My feature ya funciona y quiero meterlo en master

Hace un *PULL REQUEST!* Una vez aprobado (porque ya no rompe nada), lo mergeas a master


### Los otros estuvieron laburando y necesito bajarme los cambios

Antes de volver a laburar te fijas que tu repositorio este *actualizado*.

Te paras en master y haces

`git pull`

Vas a ver muchos cambios.

_que pasa si me olvide de hacer esto y labure y pushie_

No te apruebo el PR y ademas cuando quieras pushear vas a tener conflictos.

Que es un conflicto? Estas laburando con un archivo que ya esta en el repo, pero fue actualizado y vos te quedaste con una version vieja, tu solucion :

_desde la branch donde estas laburando(no master)_

`git pull`

`git merge master`

resolves los conflictos, y ahi estas listo para volver a pushear
