push 0
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
push 10
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
push 0
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
push -2
lfp
add
lw
sop
lfp
lfp
push 1
smo
push B
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
push B
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
push A
js
add
print
halt

value5A1:
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

A:
lmo
push 0
beq value5A1

getA4B1:
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

B:
lmo
push 0
beq value5A1
lmo
push 1
beq getA4B1
halt
