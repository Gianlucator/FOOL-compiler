push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 28
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
push 0
lfp
push fC
js
print
halt

fA:
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

fC:
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
