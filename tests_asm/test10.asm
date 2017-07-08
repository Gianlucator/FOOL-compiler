push 0
push 3
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
push 7
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
push -4
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
push get3C1
js
push -4
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
push get3C1
js
add
print
halt

get3C1:
cfp
lra
push 1
lfp
add
lw
sop
lfp
lfp
push getX4A1
js
srv
sra
pop
pop
sfp
lrv
lra
js

getX4A1:
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
