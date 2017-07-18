push 0
push A
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
push D
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
lop
sro
push -3
lfp
add
lw
sop
lfp
push -2
lfp
add
lw
lfp
push 0
smo
lop
push -2
add
lw
js
print
halt

g1C1:
cfp
lra
push 1
srv
sra
pop
pop
sfp
lrv
lra
lro
sop
js

C:
lmo
push 0
beq g1C1

g1D1:
cfp
lra
push 2
srv
sra
pop
pop
sfp
lrv
lra
lro
sop
js

D:
lmo
push 0
beq g1D1

A:

B:
halt
