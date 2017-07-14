push 0
push 2
lhp
push 0
add
sw
push A
lhp
push 1
add
sw
push 3
lhp
push 2
add
sw
lhp
push 3
add
shp
lhp
lhp
push 0
add
sw
push 10
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
push 0
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
lop
sro
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
lop
sro
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
lro
sop
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
lro
sop
js

B:
lmo
push 0
beq value5A1
lmo
push 1
beq getA4B1
halt
