push 0
push 8
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
print
halt

getThis7Numero6:
cfp
lra
lop
srv
sra
pop
sfp
lrv
lra
js

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

Numero:
lmo
push 0
beq getThis7Numero6
lmo
push 1
beq getX4Numero6
halt
