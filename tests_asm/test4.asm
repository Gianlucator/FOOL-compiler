push 0
push 2
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
push 1
lfp
add
lw
sop
lfp
lfp
push b1A1
js
srv
sra
pop
pop
sfp
lrv
lra
js

b1A1:
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
halt
