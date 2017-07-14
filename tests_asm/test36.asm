push 0
push B
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

A:

function0:
cfp
lra
push 5
srv
sra
pop
pop
sfp
lrv
lra
js

get3B1:
cfp
lra
push function0
lfp
lop
lfp
push -2
lfp
add
lw
js
srv
pop
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
beq get3B1
halt
