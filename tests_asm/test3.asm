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
push 0
smo
push X
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

X:
lmo
push 0
beq get3X1

A:

B:

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
push 0
smo
push X
js
srv
sra
pop
sfp
lrv
lra
js
halt
