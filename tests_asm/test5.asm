push fParent
push rParent
push fChild
push rChild
push 0
push 4
lhp
push 65078524
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
nullhalt

fParent:
cfp
lra
push 2
push 2
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

rParent:
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

rChild:
cfp
lra
push 3
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
