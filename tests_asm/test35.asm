push 0
push 12
lhp
sw
push 1
lhp
add
shp
push 2
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
push Numero2
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
push Numero2
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
push -2
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

getThis7Numero27:
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

Numero2:
lmo
push 0
beq getThis7Numero27
lmo
push 1
beq getX4Numero6
halt
