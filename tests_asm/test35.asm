push 0
push 12
lhp
push 0
add
sw
push Numero2
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
lro
sop
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
lro
sop
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
lro
sop
js

Numero2:
lmo
push 0
beq getThis7Numero27
lmo
push 1
beq getX4Numero6
halt
