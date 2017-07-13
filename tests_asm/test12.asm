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
print
halt

f1A1:
cfp
lra
lop
sro
lfp
lfp
push 1
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

g1A1:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
lro
sop
js

A:
lmo
push 0
beq f1A1
lmo
push 1
beq g1A1
halt
