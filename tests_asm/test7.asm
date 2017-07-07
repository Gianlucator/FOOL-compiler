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
push 7
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
halt

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
sfp
lrv
lra
js
