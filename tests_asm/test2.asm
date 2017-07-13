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
lhp
sop
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
lhp
sop
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
lhp
sop
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
lhp
sop
lop
sro
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
lop
sro
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
lop
sro
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
lop
sro
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
lro
sop
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
lro
sop
js

Numero:
lmo
push 0
beq getX4Numero6
lmo
push 1
beq getY4Numero6

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
lro
sop
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
lro
sop
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
lro
sop
js

NumeroX:
lmo
push 0
beq getX4NumeroX7
lmo
push 1
beq getY4NumeroV7

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
lro
sop
js

NumeroI:
lmo
push 0
beq getX4Numero6
lmo
push 1
beq getY4NumeroI7
halt
