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
push uA11
js
print
halt

uA11:
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

sB11:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js
