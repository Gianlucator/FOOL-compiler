push 0
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
push B
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
push F
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
lop
sro
push -2
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
push 0
smo
lop
push -2
add
lw
js
print
halt

foo3A1:
cfp
lra
push 9
srv
sra
pop
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
beq foo3A1

B:
lmo
push 0
beq foo3A1

C:
lmo
push 0
beq foo3A1

foo3F1:
cfp
lra
push 6
srv
sra
pop
pop
sfp
lrv
lra
lro
sop
js

F:
lmo
push 0
beq foo3F1
halt
