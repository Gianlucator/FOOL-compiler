push 0
push 2
lhp
push 0
add
sw
push Numero
lhp
push 1
add
sw
push 3
lhp
push 2
add
sw
lhp
push 3
add
shp
lhp
push 2
lhp
push 0
add
sw
push NumeroI
lhp
push 1
add
sw
push 3
lhp
push 2
add
sw
lhp
push 3
add
shp
lhp
push 2
lhp
push 0
add
sw
push NumeroV
lhp
push 1
add
sw
push 3
lhp
push 2
add
sw
lhp
push 3
add
shp
lhp
push 2
lhp
push 0
add
sw
push NumeroX
lhp
push 1
add
sw
push 3
lhp
push 2
add
sw
lhp
push 3
add
shp
lhp
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
