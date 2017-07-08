push 0
push 2
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
push 23
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
push unoNumero
js
push -3
lfp
add
lw
sop
lfp
lfp
push dueNumero
js
print
halt

unoNumero:
cfp
lra
push 4
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
push 22
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

dueNumero:
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
