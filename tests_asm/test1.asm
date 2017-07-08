push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 5
lhp
sw
push 1
lhp
add
shp
lhp
push function0
lfp
lfp
push -3
lfp
add
lw
js
lhp
sw
push 1
lhp
add
shp
push -2
lfp
add
lw
sop
lfp
lfp
push getX31
js
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
push 6
lhp
sw
push 1
lhp
add
shp
lhp
push 777
print
halt

getX31:
cfp
lra
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
push 3
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
push 4
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
push 2
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
lhp
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

function0:
cfp
lra
push -2
lfp
lw
add
lw
sop
lfp
lfp
push getX31
js
srv
sra
pop
sfp
lrv
lra
js
