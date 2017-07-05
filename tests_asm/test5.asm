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
push 65078524
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
push -3
lfp
add
lw
shp
push fChild
lw
js
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
pop
sfp
lrv
lra
js
