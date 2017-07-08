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
push unoNumero36
js
push -3
lfp
add
lw
sop
lfp
lfp
push dueNumero36
js
print
halt

unoNumero36:
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
push 0
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

dueNumero36:
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
