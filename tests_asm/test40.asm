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
srv
sra
pop
sfp
lrv
lra
lro
sop
js

due3Numero6:
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
beq uno3Numero6
lmo
push 1
beq due3Numero6
halt
