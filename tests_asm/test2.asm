push 0
push 2
lhp
sw
push 1
lhp
add
shp
push Numero
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
lhp
push 2
lhp
sw
push 1
lhp
add
shp
push NumeroI
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
lhp
push 2
lhp
sw
push 1
lhp
add
shp
push NumeroV
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
lhp
push 2
lhp
sw
push 1
lhp
add
shp
push NumeroX
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
lhp
push -2
lfp
add
lw
sop
lfp
lfp
push 0
smo
lop
push -2
add
lw
js
push -3
lfp
add
lw
sop
lfp
lfp
push 1
smo
lop
push -2
add
lw
js
push -4
lfp
add
lw
sop
lfp
lfp
push 0
smo
lop
push -2
add
lw
js
push -5
lfp
add
lw
sop
lfp
lfp
push 1
smo
lop
push -2
add
lw
js
add
add
add
print
halt

getX4Numero6:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js

getY4Numero6:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js

Numero:
lmo
push 0
beq getX4Numero6
lmo
push 1
beq getY4Numero6

getY4NumeroI7:
cfp
lra
push -3
lop
add
lw
push 1
add
srv
sra
pop
sfp
lrv
lra
js

NumeroI:
lmo
push 0
beq getX4Numero6
lmo
push 1
beq getY4NumeroI7

getX4NumeroV7:
cfp
lra
push -3
lop
add
lw
push 2
add
srv
sra
pop
sfp
lrv
lra
js

getY4NumeroV7:
cfp
lra
push -3
lop
add
lw
push 3
add
srv
sra
pop
sfp
lrv
lra
js

NumeroV:
lmo
push 0
beq getX4NumeroV7
lmo
push 1
beq getY4NumeroV7

getX4NumeroX7:
cfp
lra
push -3
lop
add
lw
push 3
add
srv
sra
pop
sfp
lrv
lra
js

NumeroX:
lmo
push 0
beq getX4NumeroX7
lmo
push 1
beq getY4NumeroV7
halt
