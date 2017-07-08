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
lfp
push createBA71
js
push -3
lfp
add
lw
sop
lfp
lfp
push getYB41
js
print
halt

createBA71:
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
push 0
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

getXB41:
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

getYB41:
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
