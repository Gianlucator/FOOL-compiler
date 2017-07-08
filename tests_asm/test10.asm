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
push 0
lhp
sw
push 1
lhp
add
shp
lhp
push 8
print
halt

fParent16:
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

fChild15:
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
