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
push -3
lfp
add
lw
print
halt

get3A1:
cfp
lra
push 44
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
beq get3A1

get3B1:
cfp
lra
push 555
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
beq get3B1
halt
