push 0
push 1
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
push get3X1
js
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
push 777
print
halt

get3X1:
cfp
lra
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
lhp
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
push get3X1
js
srv
sra
pop
sfp
lrv
lra
js
halt
