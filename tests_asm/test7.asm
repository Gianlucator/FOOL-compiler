push 0
push 2
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
push 10
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
push 0
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
push -2
lfp
add
lw
sop
lfp
lfp
push 1
smo
lop
push -2
add
lw
js
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
push -3
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
add
print
halt

value5A1:
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

A:
lmo
push 0
beq value5A1

getA4B1:
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

B:
lmo
push 0
beq value5A1
lmo
push 1
beq getA4B1
halt
