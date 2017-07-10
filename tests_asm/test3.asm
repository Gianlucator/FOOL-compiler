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
push -2
lfp
add
lw
sop
lfp
lfp
push getX4Numero6
js
push -3
lfp
add
lw
sop
lfp
lfp
push getY4NumeroI7
js
push -4
lfp
add
lw
sop
lfp
lfp
push getX4NumeroV7
js
push -5
lfp
add
lw
sop
lfp
lfp
push getY4NumeroV7
js
add
add
add
print
halt

getX4Numero6:
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

getY4Numero6:
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

getX4NumeroV7:
cfp
lra
push -2
lop
add
lw
push 2
add
srv
sra
pop
sfp
lrv
lra
js

getY4NumeroV7:
cfp
lra
push -2
lop
add
lw
push 3
add
srv
sra
pop
sfp
lrv
lra
js

getX4NumeroX7:
cfp
lra
push -2
lop
add
lw
push 3
add
srv
sra
pop
sfp
lrv
lra
js

getY4NumeroI7:
cfp
lra
push -2
lop
add
lw
push 1
add
srv
sra
pop
sfp
lrv
lra
js
halt
