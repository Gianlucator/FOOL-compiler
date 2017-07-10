push 0
push 1
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
lfp
push createB7A1
js
push -3
lfp
add
lw
sop
lfp
lfp
push getY4B1
js
print
halt

createB7A1:
cfp
lra
push 2
lhp
sw
push 1
lhp
add
shp
push -2
lop
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
lhp
srv
sra
pop
sfp
lrv
lra
js

getX4B1:
cfp
lra
push -2
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

getY4B1:
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
halt
