push 0
push A
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
lhp
sop
push D
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
lhp
sop
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

A:

B:

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
halt
