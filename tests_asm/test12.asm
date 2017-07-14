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
