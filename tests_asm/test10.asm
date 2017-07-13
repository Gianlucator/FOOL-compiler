push 0
push 1
lhp
sw
push 1
lhp
add
shp
lhp
push 1
lhp
sw
push 1
lhp
add
shp
lhp
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
push D
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
js

D:
lmo
push 0
beq g1D1
halt
