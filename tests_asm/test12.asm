push 0
push 1
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
push A
js
print
halt

f1A1:
cfp
lra
lfp
lfp
push 1
smo
push A
js
srv
sra
pop
sfp
lrv
lra
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
js

A:
lmo
push 0
beq f1A1
lmo
push 1
beq g1A1
halt
