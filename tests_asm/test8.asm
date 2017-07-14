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
lop
sro
push -2
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

due3Numero6:
cfp
lra
lop
sro
lfp
lfp
push 0
smo
lop
push -2
add
lw
js
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
