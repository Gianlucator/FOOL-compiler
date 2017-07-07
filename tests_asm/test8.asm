push 0
push 4
push -2
lfp
add
lw
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
push 8
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
push fChild
js
print
halt

fParent:
cfp
lra
push 1
lfp
add
lw
srv
sra
pop
pop
sfp
lrv
lra
js

fChild:
cfp
lra
push 2
push 1
lfp
add
lw
mult
srv
sra
pop
pop
sfp
lrv
lra
js
