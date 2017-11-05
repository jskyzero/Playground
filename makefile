CC = valac
Flags = --pkg gtk+-3.0 --pkg gmodule-2.0

install: timer

timer: timer.vala
	$(CC) $(Flags) $^ -o $@

clean:
	rm timer