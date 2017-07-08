push 0
push 5
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
push 0
lhp
sw
push 1
lhp
add
shp
lhp
push 2
lhp
sw
push 1
lhp
add
shp
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
push -3
lfp
add
lw
lfp
push aparam6B1
js
print
halt

aparam6B1:
cfp
lra
push -3
lop
add
lw
push 1
lfp
add
lw
sop
lfp
lfp
push afun4A1
js
mult
srv
sra
pop
pop
sfp
lrv
lra
js

afun4A1:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js
