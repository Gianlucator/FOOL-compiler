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
push g1D1
js
print
halt

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
halt
