push 0
push X
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
lop
push -2
add
lw
js
lhp
sw
push 1
lhp
add
shp
push B
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
push 777
print
halt

get3X1:
cfp
lra
push A
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
push A
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
push B
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
push A
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
push B
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
lop
push -2
add
lw
js
srv
sra
pop
sfp
lrv
lra
js
halt
