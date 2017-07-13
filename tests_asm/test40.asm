push 0
push 2
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
push Numero
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
push Numero
js
print
halt

uno3Numero6:
cfp
lra
push 4
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
srv
sra
pop
sfp
lrv
lra
js

due3Numero6:
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
beq uno3Numero6
lmo
push 1
beq due3Numero6
halt
