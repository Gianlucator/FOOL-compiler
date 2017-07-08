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
push 18
lhp
sw
push 1
lhp
add
shp
lhp
push 3
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
push 19
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
push unoNumero
js
push -4
lfp
add
lw
sop
lfp
lfp
push dueNumero
js
push -5
lfp
add
lw
sop
lfp
lfp
push dueNumero
js
add
print
halt

unoNumero:
cfp
lra
push 2
push -3
lop
add
lw
mult
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
push 17
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
