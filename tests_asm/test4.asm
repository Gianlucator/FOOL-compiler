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
push -2
lfp
add
lw
sop
lfp
lfp
push k1B1
js
push -2
lfp
add
lw
sop
lfp
lfp
push u1B1
js
add
print
halt

u1A1:
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

k1A1:
cfp
lra
push 5
srv
sra
pop
sfp
lrv
lra
js

u1B1:
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

k1B1:
cfp
lra
push 6
srv
sra
pop
sfp
lrv
lra
js

s1B1:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js
halt
