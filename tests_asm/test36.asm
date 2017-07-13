push 0
push 1
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
push 0
smo
push B
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
js

B:
lmo
push 0
beq get3B1
halt
