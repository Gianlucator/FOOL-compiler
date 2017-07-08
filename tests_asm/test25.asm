push 0
push 1
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
push 35
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
push createBA
js
push -3
lfp
add
lw
sop
lfp
lfp
push getYB
js
print
halt

createBA:
cfp
lra
push 2
lhp
sw
push 1
lhp
add
shp
push -3
lop
add
lw
lhp
sw
push 1
lhp
add
shp
push 4
lhp
sw
push 1
lhp
add
shp
push 34
lhp
sw
push 1
lhp
add
shp
lhp
srv
sra
pop
sfp
lrv
lra
js

getXB:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js

getYB:
cfp
lra
push -4
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js
