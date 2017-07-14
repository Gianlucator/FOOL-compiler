push 0
push X
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
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
push 0
add
sw
lop
sro
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
push 1
add
sw
push B
lhp
push 2
add
sw
push 4
lhp
push 3
add
sw
lhp
push 4
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
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
lhp
push 0
add
sw
push A
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
lhp
push 1
add
sw
push B
lhp
push 2
add
sw
push 4
lhp
push 3
add
sw
lhp
push 4
add
shp
lhp
lhp
push 0
add
sw
push A
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
lhp
push 1
add
sw
push B
lhp
push 2
add
sw
push 4
lhp
push 3
add
sw
lhp
push 4
add
shp
lhp
srv
sra
pop
sfp
lrv
lra
lro
sop
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
lop
sro
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
