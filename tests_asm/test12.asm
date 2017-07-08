push 0
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
push 2
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
push foo3A1
js
print
halt

foo3A1:
cfp
lra
push 9
srv
sra
pop
pop
sfp
lrv
lra
js

foo3F1:
cfp
lra
push 6
srv
sra
pop
pop
sfp
lrv
lra
js
halt
