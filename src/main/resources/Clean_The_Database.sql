/*
    This Script Will Clear Any Data Within The Tables
*/

DELETE FROM APP.dbo.Procedures
DBCC CHECKIDENT ('APP.dbo.Procedures',RESEED, 0)

DELETE FROM APP.dbo.Invoices
DBCC CHECKIDENT ('APP.dbo.Invoices',RESEED, 0)

DELETE FROM APP.dbo.Pets
DBCC CHECKIDENT ('APP.dbo.Pets',RESEED, 0)

DELETE FROM APP.dbo.Users
DBCC CHECKIDENT ('APP.dbo.Users',RESEED, 0)